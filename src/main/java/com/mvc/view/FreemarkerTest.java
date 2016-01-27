package com.mvc.view;

import freemarker.template.Configuration;
import freemarker.template.Template;

import javax.servlet.jsp.PageContext;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreemarkerTest {
	
	public void execute(PageContext pageContext) throws Exception
    {        
        Configuration cfg = new Configuration();        
        // 设置模板的路径
        cfg.setServletContextForTemplateLoading(pageContext.getServletContext(), 
        										"templates");        
        Map root = new HashMap();
        root.put("name", "Tom");        
        // 获取模板文件
        Template t = cfg.getTemplate("test.ftl");        
        Writer out = pageContext.getResponse().getWriter();        
        t.process(root, out);
    }
}
