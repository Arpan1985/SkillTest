package com.testyourskills.arch.mapper;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.testyourskills.entitybean.AnswerBean;
import com.testyourskills.entitybean.OptionsBean;
import com.testyourskills.entitybean.QuestionBean;
import com.testyourskills.entitybean.ValidTopicBean;
import com.testyourskills.vo.AnswerVO;
import com.testyourskills.vo.OptionsVO;
import com.testyourskills.vo.QuestionVO;
import com.testyourskills.vo.ValidTopicVO;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.metadata.ClassMapBuilder;

/**
 * Orika mapper exposed as a Spring Bean. It contains the configuration for the mapper factory and factory builder. It will scan
 * the Spring application context searching for mappers and converters to register them into the factory. To use it we just need
 * to autowire it into our class.
 * 
 * @author dlizarra
 *
 */
@Component
public class OrikaBeanMapper extends ConfigurableMapper implements ApplicationContextAware {

	private MapperFactory factory;
	private ApplicationContext applicationContext;

	public OrikaBeanMapper() {
		super(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(MapperFactory factory) {
		this.factory = factory;
		addAllSpringBeans(applicationContext);
	}

	/**
	 * Constructs and registers a {@link ClassMapBuilder} into the {@link MapperFactory} using a {@link Mapper}.
	 * 
	 * @param mapper
	 */
	@SuppressWarnings("rawtypes")
	public void addMapper(Mapper<?, ?> mapper) {
		factory.classMap(QuestionBean.class,QuestionVO.class).exclude("qnDesc")
		.byDefault()
		.register();
		
		factory.classMap(QuestionVO.class,QuestionBean.class)
		.exclude("qnDesc")
		.byDefault()
		.register();
		
		factory.classMap(ValidTopicBean.class,ValidTopicVO.class)
		.byDefault()
		.register();
		
		factory.classMap(OptionsBean.class,OptionsVO.class)
		.byDefault()
		.register();
		
		factory.classMap(AnswerBean.class,AnswerVO.class)
		.byDefault()
		.register();
	}

	/**
	 * Scans the appliaction context and registers all Mappers and Converters found in it.
	 * 
	 * @param applicationContext
	 */
	@SuppressWarnings("rawtypes")
	private void addAllSpringBeans(final ApplicationContext applicationContext) {
		Map<String, Mapper> mappers = applicationContext.getBeansOfType(Mapper.class);
		for (Mapper mapper : mappers.values()) {
			addMapper(mapper);
		}
	}
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
		init();
	}

}