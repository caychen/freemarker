package org.com.cay.custom.directive;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import freemarker.core.Environment;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateBooleanModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateScalarModel;

@Component
public class RoleDirective implements TemplateDirectiveModel {

	/*
	 * (non-Javadoc)
	 * 
	 * @see freemarker.template.TemplateDirectiveModel#execute(freemarker.core.
	 * Environment, java.util.Map, freemarker.template.TemplateModel[],
	 * freemarker.template.TemplateDirectiveBody)
	 * 
	 * env：环境变量 params：指令参数 loopVars：循环变量 body：指令内容
	 * 
	 */
	@Override
	public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException {
		// TODO Auto-generated method stub
		TemplateScalarModel user = (TemplateScalarModel) params.get("user");
		TemplateScalarModel role = (TemplateScalarModel) params.get("role");

		if ("123456".equals(user.getAsString()) && "admin".equals(role.getAsString())) {
			loopVars[0] = TemplateBooleanModel.TRUE;

			List<String> otherRights = new ArrayList<String>();
			otherRights.add("insert");
			otherRights.add("update");
			otherRights.add("delete");

			loopVars[1] = new SimpleSequence(otherRights, null);
		} else {
			loopVars[0] = TemplateBooleanModel.FALSE;
			List<String> otherRights = new ArrayList<String>();
			otherRights.add("select");

			loopVars[1] = new SimpleSequence(otherRights, null);
		}

		body.render(env.getOut());
	}

}
