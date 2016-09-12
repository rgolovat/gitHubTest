package pageobject;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.reflect.*;

/**
 * Created by rgolovatyi on 9/12/2016.
 */
public class PageObjectFactory {


        public static <T extends BasePage> T getPage(Browser browser, Class<T> clazz) {
            FindBy classFindBy = clazz.getAnnotation(FindBy.class);
            Constructor constructor;
            try {
                constructor = clazz.getConstructor(new Class[]{Browser.class});
                T pageObj = (T) constructor.newInstance(browser);
                pageObj.by = getReferencedBy(classFindBy);
                initPageItem(browser, pageObj);
                return pageObj;
            } catch (ReflectiveOperationException e) {
                System.out.print("Fail to get Page Object\n");
                e.printStackTrace();
                throw new RuntimeException(clazz.getName() + " could not generate");
            }
        }

        private static void initPageItem(Browser browser, BasePage pageObj) {
            for (Field field : pageObj.getClass().getFields()) {
                FindBy findBy = field.getAnnotation(FindBy.class);
                Constructor constructor;
                try {
                    constructor = field.getType().getConstructor(new Class[]{Browser.class, By.class});
                    field.set(pageObj, constructor.newInstance(browser, getReferencedBy(findBy)));
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        }

        public static By getReferencedBy(FindBy findBy) {
            if (findBy==null){
                return null;
            }
            String value = findBy.using();
            switch (findBy.how()) {
                case CLASS_NAME:
                    return By.className(value);
                case CSS:
                    return By.cssSelector(value);
                case ID:
                    return By.id(value);
                case NAME:
                    return By.name(value);
                case XPATH:
                    return By.xpath(value);
            }
            throw new EnumConstantNotPresentException(How.class, "Not found constant type " + findBy);
        }

    }
