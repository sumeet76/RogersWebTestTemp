 package com.rogers.pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ReusableActions;

/**
 * The type Base page class.
 */
public class BasePageClass {
  /**
   * The Wait.
   */
  protected WebDriverWait wait;
  /**
   * The Driver.
   */

  /**
   * The Action.
   */
  //TouchActions action;
  /**
   * The Time out seconds.
   */
  static final int TIME_OUT_SECONDS = 20;
  /**
   * The Act.
   */
  /**
   * The Reusable actions.
   */
  private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
  private static final ThreadLocal<ReusableActions> reusableActionsThreadLocal = new ThreadLocal<>();
  private static final ThreadLocal<Actions> actionsThreadLocal = new ThreadLocal<>();
  /**
   * Instantiates a new Base page class.
   *
   * @param driver the driver
   */
  public BasePageClass(WebDriver driver) {

    webDriverThreadLocal.set(driver);
    PageFactory.initElements(getDriver(), this);
    actionsThreadLocal.set(new Actions(getDriver()));
    reusableActionsThreadLocal.set(new ReusableActions(getDriver()));
  }

  /**
   * This method returns the WebDriver instance from the ThreadLocal
   */
  protected WebDriver getDriver(){
    return webDriverThreadLocal.get();
  }

  /**
   * This method returns the ReusableActions class instance from the ThreadLocal
   */
  protected ReusableActions getReusableActionsInstance(){
    return reusableActionsThreadLocal.get();
  }

  /**
   * This method return the Actions class instance from the ThreadLocal
   */

  protected Actions getActionsInstance(){
    return actionsThreadLocal.get();
  }


  /**
   * Gets default time out.
   *
   * @return the default time out
   */
  protected long getDefaultTimeOut() {
    return TIME_OUT_SECONDS;
  }

  /**
   * Gets driver url.
   *
   * @return the driver url
   */
  protected String get_Driver_Url() {
    return getDriver().getCurrentUrl();
  }

  /**
   * Gets getDriver().
   *
   * @return the driver
   */

  /**
   * Move the element to center page of the screen
   * @param element
   * @author vedachalam.vasudevan
   */
  public void moveToCenterOfScreen(WebElement element) {
    JavascriptExecutor jse = (JavascriptExecutor)getDriver();
    jse.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'})", element);
  }


}
