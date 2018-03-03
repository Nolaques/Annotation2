package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;

public class HtmlGenerator {

    public static void main(String[] args)  {


        Writer writer;

        try {
            writer = new FileWriter("C:/Doc.html");


        Class<?> clazz = DocumentClass.class;

        boolean isHtmlUL = clazz.isAnnotationPresent(AnnHtmlUL.class);

        StringBuilder sb = new StringBuilder();

        if (isHtmlUL){

            AnnHtmlUL annUL = clazz.getAnnotation(AnnHtmlUL.class);

            sb.append("<H3>"+clazz.getName() + "</H3");
            sb.append("\n");

            String border = annUL.border();

            sb.append("<UL style = 'border:>"+border + "'>");


        sb.append("\n");

        Method[] methods = clazz.getMethods();

        for (Method method:methods
             ) {
            if (method.isAnnotationPresent(AnnHtmlLI.class)){
                AnnHtmlLI annLI = method.getAnnotation(AnnHtmlLI.class);

                String background = annLI.background();
                String color = annLI.color();

                sb.append("<LI style = 'margin:5px;padding:5px;background:" +
                background + ";color:"+ color+"'>");
                        sb.append("\n");
                sb.append(method.getName());
                sb.append("\n");
                sb.append("</LI>");
                sb.append("\n");

            }
        }
        sb.append("<UL>");
    }



        writer.write(String.valueOf(sb));
        writer.flush();
        writer.close();

        writeToFile(clazz.getSimpleName()+".html", sb);

        } catch (IOException e) {
            e.printStackTrace();
        }
 }


    private static void writeToFile(String fileName, StringBuilder sb) {
        System.out.println(sb);
    }
}
