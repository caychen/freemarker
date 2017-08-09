package org.com.cay.custom.function;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import freemarker.template.SimpleSequence;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModelException;

public class SortIntMethod implements TemplateMethodModelEx{

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Object exec(List arguments) throws TemplateModelException {
		// TODO Auto-generated method stub
		
		SimpleSequence arg0 = (SimpleSequence)arguments.get(0);
		List<?> aa = arg0.toList();
		System.out.println(arg0.toList().get(0).getClass().getName());//BigDecimal
		
		List<BigDecimal> list = arg0.toList();
		
		Collections.sort(list, new Comparator<BigDecimal>() {

			@Override
			public int compare(BigDecimal o1, BigDecimal o2) {
				// TODO Auto-generated method stub
				return  o1.intValue() - o2.intValue();
			}
		});
		return list;
	}

}
