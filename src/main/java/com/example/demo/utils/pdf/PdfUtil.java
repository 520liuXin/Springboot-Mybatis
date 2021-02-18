package com.example.demo.utils.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.*;

import java.net.URLEncoder;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
 * @Description
 * @auther Tian
 * @Date 2020/4/11 13:28
 **/
public class PdfUtil {
    /**
     * PDF模板路径
     **/
    private final static String pdfPath="F:/20200929JAVACODE/file/pdf/";


    /**
     * 利用模板生成pdf保存到某路径下
     */
    public static void pdfOut(String modalFilename,String newFilename,Map<String, Object> inputMap) {

        // 生成的新文件路径
        String path0 = pdfPath;
        File f = new File(path0);
        if (!f.exists()) {
            f.mkdirs();
        }
        // 模板路径
        String templatePath =pdfPath+modalFilename;
        // 创建文件夹
        String newPdfPath = pdfPath+newFilename;
        File file = new File(templatePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File file1 = new File(newPdfPath);
        if (!file1.exists()) {
            try {
                file1.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            String path = "C:/WINDOWS/Fonts/simsun.ttc,0";//windows里的字体资源路径
            BaseFont bf = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 输出流
            out = new FileOutputStream(newPdfPath);
            // 读取pdf模板
            reader = new PdfReader(templatePath);
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            //文字类的内容处理
            Map<String, String> datemap = (Map<String, String>) inputMap.get("dateMap");
            form.addSubstitutionFont(bf);
            for (String key : datemap.keySet()) {
                String value = datemap.get(key);
                form.setField(key, value);
            }
            stamper.setFormFlattening(false);
            stamper.close();
            Document doc = new Document(PageSize.LETTER.rotate());//pdf横向打开
            doc.setPageSize(PageSize.A4);
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();
            out.close();
            reader.close();
        } catch (IOException | DocumentException e) {
            System.out.println(e);
        }

    }

    /**
     * 利用模板生成pdf导出
     */
    public static void pdfExport(String modalFilename,String newFilename, HttpServletResponse response,Map<String, Object> inputMap) {

        // 生成的新文件路径
        String path0 = pdfPath;
        File f = new File(path0);

        if (!f.exists()) {
            f.mkdirs();
        }
        // 模板路径
        String templatePath =pdfPath+modalFilename;

        File file = new File(templatePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PdfReader reader;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        OutputStream out = null;
        try {
            Map<String, String> datemap = (Map<String, String>) inputMap.get("dateMap");
            String path = "C:/WINDOWS/Fonts/simsun.ttc,0";//windows里的字体资源路径
            BaseFont bf = BaseFont.createFont(path, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
            // 输出流
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition",
                    "attachment;fileName=" + URLEncoder.encode(newFilename, "UTF-8"));
            out = new BufferedOutputStream(response.getOutputStream());
            // 读取pdf模板
            reader = new PdfReader(templatePath);
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            //文字类的内容处理
            form.addSubstitutionFont(bf);
            for (String key : datemap.keySet()) {
                String value = datemap.get(key);
                form.setField(key, value);
            }
            stamper.setFormFlattening(false);
            stamper.close();
            Document doc = new Document(PageSize.LETTER.rotate());//pdf横向打开
            doc.setPageSize(PageSize.A4);
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();
            reader.close();
        } catch (IOException | DocumentException e) {
            System.out.println(e);
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 读取本地pdf,这里设置的是预览
     */
    public static void readPdf(String filename,HttpServletResponse response) {
        response.reset();
        response.setContentType("application/pdf");
        try {
            File file = new File(pdfPath+filename);
            FileInputStream fileInputStream = new FileInputStream(file);
            OutputStream outputStream = response.getOutputStream();
            IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
            response.setHeader("Content-Disposition",
                    "inline; filename= "+filename);
            outputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}