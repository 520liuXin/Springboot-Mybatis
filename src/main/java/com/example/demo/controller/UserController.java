package com.example.demo.controller;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.entity.Bo.UserExportBo;
import com.example.demo.entity.GwclwxsqBean;
import com.example.demo.entity.UserInfo;
import com.example.demo.enums.ErrorCodeAndMsg;
import com.example.demo.utils.BeanConvertUtils;
import com.example.demo.utils.CommonUtils;
import com.example.demo.utils.ExportExcelUtils;
import com.example.demo.utils.ResponseInfo;
import com.example.demo.utils.excel.ExportExcel;
import com.example.demo.utils.pdf.PdfUtil;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping(value = "/user", method = { RequestMethod.GET, RequestMethod.POST })
public class UserController {



	@RequestMapping("/ListUser")
	@ResponseBody
	public List<UserInfo> ListUser(){
		return userservice.ListUser();
	}

	@RequestMapping("/ListUserByname")
	@ResponseBody
	public List<UserInfo> ListUserByname(String name){
		return userservice.findByName(name);
	}
	@Autowired
	private UserService userservice;

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(int id) {
		int result = userservice.Delete(id);
		if (result >= 1) {
			return "删除成功";
		} else {
			return "删除失败";
		}
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(UserInfo user) {
		int result = userservice.Update(user);
		if (result >= 1) {
			return "修改成功";
		} else {
			return "修改失败";
		}

	}

	@PostMapping("/insert")
	public ResponseInfo<?> insert(@RequestBody @Validated UserInfo userDTO) {
		log.info(userDTO.toString());
		int i= userservice.UserService(userDTO);
		return new  ResponseInfo(i==1 ? ErrorCodeAndMsg.SUCCESS : ErrorCodeAndMsg.USER_FAIL);
		}
	/**
	 * 走参数校验注解，进行参数
	 *
	 * @param userDTO
	 * @return
	 */
	@PostMapping("/save/valid")
	public ResponseInfo<?> save(@RequestBody @Validated UserInfo userDTO) {
		userservice.findByName(userDTO.getUsername());
		return  new ResponseInfo(ErrorCodeAndMsg.SUCCESS,userDTO);
	}

	/**
	 * @description  全量用户信息导出 Export all user information
	 * @author liuxin
	 * @date 2020/12/28 [reqDTO, response]
	 * @return java.lang.Object
	 **/
	@PostMapping("/Export")
	public Object exportUserInfo(HttpServletResponse response) {
		try {
			List<UserInfo> userInfoList = userservice.ListUser();
            List<UserExportBo> UserExportBoList = new ArrayList<>();
            log.info("查询结果"+userInfoList.toString());
            if (CommonUtils.isNotEmpty(userInfoList)) {
                UserExportBoList = BeanConvertUtils.convertList(userInfoList, UserExportBo.class);
                log.info("复制后结果"+UserExportBoList.toString());
            }


            //浏览器实时导出
			String fileName = "用户数据导出20210129";
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-Type", "application/vnd.ms-excel");
			response.setHeader("Content-Disposition",
					"attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xls");
		    new  ExportExcel(fileName, UserExportBo.class).setDataList(UserExportBoList).write(response.getOutputStream());

//
//		    //导出至本地
//		         String file = fileName  + ".xls";
//		         String path="C:/Users/刘先生/Desktop";
//			new  ExportExcel(fileName, UserExportBo.class).setDataList(UserExportBoList).writeFile(path + "/" +file);
		} catch (Exception e) {
			log.error("根据条件导出数据：%s", e.getMessage(), e);
		}
		return null;
	}



    /**
     * @description 事务测试 手动提交事务  ,sptingboot 手动事务控制：你把需要提交事务的逻辑写在子方法中，用这个注解Transactional提交不就行了
     * @author liuxin
     * @date 2021/2/4 [userDTO]
     * @return com.example.demo.utils.ResponseInfo<?>
     **/
	@GetMapping("/save")
	public ResponseInfo<?> commitTransaction() {
		userservice.commitTransaction();
		return  new ResponseInfo(ErrorCodeAndMsg.SUCCESS);
	}

	/**
	 * @description
	 * @author liuxin  PDF导出
	 * @date 2021/2/18
	 * @return
	 **/
	@RequestMapping(value = "/DM/gwclwxsq/qygl/exportPDF$m=query.service",method =RequestMethod.POST)
	public String exportPdf(@RequestBody GwclwxsqBean gwclwxsqBean, HttpServletResponse response) throws UnsupportedEncodingException {
		// 1.指定解析器
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
		String filename="template.pdf";
		String path="F:/20200929JAVACODE/file/pdf/";
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ URLEncoder.encode(filename, "UTF-8"));
//		GwclwxsqBean gwclwxsqBean =new GwclwxsqBean();
//		gwclwxsqBean.setEmail("5466");
//		gwclwxsqBean.setIdCard("455");
//		gwclwxsqBean.setImgurl("4");
//		gwclwxsqBean.setMobile("5656");
//		gwclwxsqBean.setUsername("55457897778");
		OutputStream os = null;
		PdfStamper ps = null;
		PdfReader reader = null;
		try {
			os = response.getOutputStream();
			// 2 读入pdf表单
			reader = new PdfReader(path+ "/"+filename);
			// 3 根据表单生成一个新的pdf
			ps = new PdfStamper(reader, os);
			// 4 获取pdf表单
			AcroFields form = ps.getAcroFields();
			// 5给表单添加中文字体 这里采用系统字体。不设置的话，中文可能无法显示
			BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1",
					BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
			form.addSubstitutionFont(bf);
			// 6查询数据================================================
			Map<String, String> data = new HashMap<String, String>();
			data.put("username", gwclwxsqBean.getUsername());
			data.put("mobile", gwclwxsqBean.getMobile());
			data.put("email", gwclwxsqBean.getEmail());
			data.put("imgurl", gwclwxsqBean.getImgurl());
			data.put("idCard", gwclwxsqBean.getIdCard());
			for (String key : data.keySet()) {
				form.setField(key,data.get(key).toString());
			}
			ps.setFormFlattening(true);
			log.info("*******************PDF导出成功***********************");
		} catch (Exception e) {          log.error("*******************PDF导出失败***********************");
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				reader.close();
				os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * @description
	 * @author liuxin  PDF导出-工具类
	 * @date 2021/2/18
	 * @return
	 **/
	@GetMapping("/downPdf")
	public void downloadPDF(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//PdfUtil.pdfExport("report1.pdf",response);;//导出文件
		Map<String, Object> dataMap=new HashMap<>();
		Map<String,String> dataMap1=new HashMap<>();
		dataMap1.put("name1","overs202004111610");
		dataMap.put("dateMap",dataMap1);
		//PdfUtil.pdfOut("report1.pdf","report2.pdf",dataMap);//生成文件
		//PdfUtil.readPdf("report2.pdf",response);//预览文件
		PdfUtil.pdfExport("report1.pdf", "test.pdf",response,dataMap);;//导出文件
	}




}
