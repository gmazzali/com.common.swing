package com.crud.swing.view.search;

import java.awt.BorderLayout;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.common.swing.model.Element;
import com.common.swing.model.ElementServiceImpl;
import com.common.swing.view.callback.CallbackFilter;
import com.common.swing.view.component.ElementSearchForm;
import com.common.util.business.tool.collection.CollectionUtil;
import com.common.util.persistence.filter.BaseFilter;
import com.crud.swing.Constants;
import com.crud.swing.view.container.impl.DialogContainer;

/**
 * La clase de prueba de la ventana de b�squeda de entidades.
 * 
 * @since 22/10/2014
 * @author Guillermo Mazzali
 * @version 1.0
 */
@RunWith(MockitoJUnitRunner.class)
public class SearchFormTest {

	@InjectMocks
	private ElementSearchForm panel;

	@BeforeClass
	public static void initClass() {
		BasicConfigurator.configure();
	}

	/**
	 * Pruebas sobreun listado sin acciones.
	 */
	@Test
	public void testSearchForm() {
		ElementServiceImpl service = new ElementServiceImpl() {
			private static final long serialVersionUID = 1L;

			@Override
			public List<Element> findByFilter(BaseFilter<Element, Integer> filter) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				return super.findByFilter(filter);
			}
		};
		service.save(new Element("ELEMENTO 1"));
		service.save(new Element("ELEMENTO 2"));
		service.save(new Element("ELEMENTO 3"));
		service.save(new Element("ELEMENTO 4"));
		service.save(new Element("ELEMENTO 5"));
		service.save(new Element("ELEMENTO 6"));
		service.save(new Element("ELEMENTO 7"));
		service.save(new Element("ELEMENTO 8"));
		service.save(new Element("ELEMENTO 9"));
		service.save(new Element("ELEMENTO 0"));

		this.panel.setService(service);
		this.panel.addCallbackFilter(new CallbackFilter<Element>() {
			private static final long serialVersionUID = 1L;

			@Override
			public void updateEntities(Collection<Element> entities) {
				if (CollectionUtil.isNotEmpty(entities)) {
					for (Element element : entities) {
						System.out.println(element.toString());
					}
				} else {
					System.out.println("VACIA");
				}
			}
		});

		final DialogContainer dialog = new DialogContainer();
		dialog.getContentPane().removeAll();
		dialog.getContentPane().add(panel, BorderLayout.CENTER);
		dialog.pack();
		dialog.setModal(true);
		dialog.setAlwaysOnTop(Constants.alwaysTop);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(Constants.visible);
	}
}