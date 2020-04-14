package hw3.pages;

import hw3.pages.components.Benefits;
import hw3.pages.components.IFrameElements;
import hw3.pages.components.HeaderMenu;
import hw3.pages.components.SideBarMenu;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class HomePage extends AbstractPage{

    private Benefits benefits;
    private IFrameElements IFrameElements;

    public HomePage(WebDriver driver) {
        super(driver);
        this.headerMenu = new HeaderMenu(driver);
        this.benefits = new Benefits(driver);
        this.IFrameElements = new IFrameElements(driver);
        this.sideBarMenu = new SideBarMenu(driver);
    }

    public void login(String username, String password){
        headerMenu.login(username, password);
    }

    public boolean isUserNameDisplayed(){
        return headerMenu.isUserNameDisplayed();
    }

    public String getUserName(){
        return headerMenu.getUserName();
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public List<String> getHeaderMenuText(){
        return headerMenu.getHeaderMenuItemsText();
    }

    public boolean isHeaderMenuItemsDisplayed(){
        return headerMenu.isHeaderMenuItemsDisplayed(); }

    public int getBenefitIconsNumber(){
        return benefits.getBenefitIconsNumber();
    }

    public int getBenefitTextsNumber(){
        return benefits.getBenefitTextsNumber();
    }

    public List<String> getBenefitTexts(){
        return benefits.getBenefitTexts();
    }

    public boolean isBenefitIconsDisplayed(){
        return benefits.isBenefitIconsDisplayed();
    }

    public void openDifferentElementsPage(){
        headerMenu.openDifferentElementsPage(); }

    public boolean isIFrameDisplayed(){
        return IFrameElements.isIFrameDisplayed();
    }

    public boolean isFrameButtonDisplayed(){
        return IFrameElements.isButtonDisplayed();
    }

    public void switchToIFrame(){
        IFrameElements.switchToIFrame();
    }

    public void switchToOriginalWindow(){
        IFrameElements.switchToOriginalWindow();
    }

    public boolean isSideBarMenuItemsDisplayed(){
        return sideBarMenu.isSideBarMenuItemsDisplayed();
    }

    public List<String> getSideBarMenuItemsText(){
        return sideBarMenu.getSideBarMenuItemsText(); }

    public int getSideBarMenuItemsNumber(){
        return sideBarMenu.getSideBarMenuItemsNumber();
    }


}