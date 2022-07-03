package com.volkruss.autogenentity.logic;

import com.volkruss.autogenentity.config.GenProperties;
import com.volkruss.autogenentity.model.OutModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class GenerateJavaFile {

    private static final String OUT_PAHT = "generated/auto";

    @Autowired
    private GenProperties genProperties;

    /**
     * 指定したテキストファイルのパスからテンプレートテキストファイルを読み込み
     * 引数に与えた埋め込み変数を設定して
     * TemplateEngineにて出力すべきテキストファイルの内容を出力し保存します。
     *
     * @return
     */
     public void generateTextWithTemplate(String txtFilePath, List<OutModel> outModels) {

         ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
         resolver.setTemplateMode("TEXT");
         resolver.setCharacterEncoding("UTF-8");

         TemplateEngine engine = new TemplateEngine();
         engine.setTemplateResolver(resolver);

         for(OutModel model : outModels){
             Context context = new Context();
             context.setVariable("model",model);
             context.setVariable("package",genProperties.get("package"));
             String result = engine.process(txtFilePath,context);
             Path path = getSavePath(model.tableName);
             try {
                 writeFile(result,path);
             } catch (IOException e) {
                 e.printStackTrace();
             }
         }
     }

    /**
     * TableName.java でパスを作成する。
     *
     * @param tableName
     * @return
     */
    private Path getSavePath(String tableName){
        return Paths.get(genProperties.get("outpath"),tableName + ".java");
    }

    /**
     * 指定したテキストを指定したパスに書き込みます
     *
     * @param template
     * @param path
     * @throws IOException
     */
    private void writeFile(String template,Path path) throws IOException {
        File file = path.toFile();
        file.getParentFile().mkdirs();
        file.createNewFile();
        FileWriter writer = new FileWriter(file);
        writer.write(template);
        writer.close();
    }
}
