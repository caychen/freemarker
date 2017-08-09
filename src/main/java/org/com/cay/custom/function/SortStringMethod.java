package org.com.cay.custom.function;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import freemarker.template.SimpleScalar;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class SortStringMethod implements TemplateMethodModelEx {

	@Override
	public Object exec(List arguments) throws TemplateModelException {
		// TODO Auto-generated method stub
		
		SimpleSequence arg0 = (SimpleSequence)arguments.get(0);
		
		//System.out.println(arg0.toList().get(0).getClass().getName());//String
		List<String> list = arg0.toList();
		
		Collections.sort(list, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}});
		return list;
	}

}
