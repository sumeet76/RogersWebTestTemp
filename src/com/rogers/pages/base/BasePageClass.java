 package com.rogers.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
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
  protected WebDriver driver;
  /**
   * The Action.
   */
  TouchActions action;
  /**
   * The Time out seconds.
   */
  static final int TIME_OUT_SECONDS = 20;
  /**
   * The Act.
   */
  Actions act;
  /**
   * The Reusable actions.
   */
  protected ReusableActions reusableActions;

  /**
   * Instantiates a new Base page class.
   *
   * @param driver the driver
   */
  public BasePageClass(WebDriver driver) {

    this.driver = driver;
    PageFactory.initElements(driver, this);
    act = new Actions(driver);
    reusableActions = new ReusableActions(this.driver);
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
    return driver.getCurrentUrl();
  }

  /**
   * Gets driver.
   *
   * @return the driver
   */
  protected WebDriver getDriver() {
    return driver;
  }



}
