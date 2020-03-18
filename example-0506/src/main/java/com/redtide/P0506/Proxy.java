package com.redtide.P0506;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;

/**
 * Created by zsq on 2020/3/14.
 */
public class Proxy{

    public static void main(String[] args)throws Exception{
        File file = new File("");
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
        Iterable units = fileManager.getJavaFileObjects(file);
        JavaCompiler.CompilationTask task = compiler.getTask(null,fileManager,null,null,null,units);
        task.call();
        fileManager.close();
    }

}
