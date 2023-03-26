package com.roc.SuperMaster.utility.fileUtil;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.parser.Parser.Builder;
import org.commonmark.renderer.html.HtmlRenderer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @ClassName MdToPdfConverter
 * @Author: WangPeng
 * @Description: 将Markdown文件转换成PDF文件
 * @date 2023/3/26 23:16
 * @Version 1.0.0
 */
public class MdToPdfConverter {
    public static void mdToPdfConverter() throws IOException, DocumentException {
        // 读取Markdown文件
        String inputFileName = "D:\\GitHubWarehouse\\MyNotes\\Force\\Java\\JavaNotes\\java\\3.QPS.md"; // 输入文件路径
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(System.lineSeparator());
        }
        String markdown = stringBuilder.toString();
        reader.close();

        // 将Markdown格式转换成HTML格式
        Parser parser = new Builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        String html = renderer.render(document);

        // 将HTML格式转换成PDF格式
        String outputFileName = "D:/GitHubWarehouse/MyNotes/Force/Java/JavaNotes/javaWeb/example.pdf";// 输出文件路径
        Document documentPdf = new Document(PageSize.A4);
        String fontPath = "src/main/resources/fonts/msyhbd.ttf"; // 字体文件路径
        BaseFont baseFont = BaseFont.createFont(fontPath, BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
        Font font = new Font(baseFont, 12);

        InputStream input = new ByteArrayInputStream(html.getBytes());
        PdfWriter writer = PdfWriter.getInstance(documentPdf, Files.newOutputStream(Paths.get(outputFileName)));
        documentPdf.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, documentPdf, input, StandardCharsets.UTF_8, new FontProvider() {
            @Override
            public Font getFont(String fontName, String encoding, boolean embedded, float size, int style, BaseColor color) {
                return font;
            }

            @Override
            public boolean isRegistered(String fontName) {
                return false;
            }
        });
        documentPdf.close();
    }
}
