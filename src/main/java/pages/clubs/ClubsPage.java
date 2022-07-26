package pages.clubs;

import org.openqa.selenium.*;
import pages.BasePage;
import pages.header.HeaderComponent;

import java.util.ArrayList;
import java.util.List;


public class ClubsPage extends BasePage {
    private PaginationComponent paginationComponent;

    private ListCardViewComponent listCardViewComponent;
    private BlockCardViewComponent blockCardViewComponent;

    private SortClubComponent sortClubComponent;
    private CardComponent clubPageComponent;
    private AdvancedSearchPanelComponent advancedSearchPanelComponent;
    private WebElement advancedSearchButton;
    private HeaderComponent header;
    private WebElement pageIdentifier;

//    List<CardComponent> cards;
//
//    public void getCards() {
//        List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
//        this.cards = new ArrayList<>();
//        for (WebElement card : cards) {
//            this.cards.add(new CardComponent(driver, card));
//        }
//    }

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public HeaderComponent getHeader() {
        if (header == null) {
            header = new HeaderComponent(driver);
        }
        return header;
    }

    public ClubsPage waitForClubsPageToOpen() {
        waitForPageToReload();
        return this;
    }

    public AdvancedSearchPanelComponent getAdvancedSearchPanelComponent() {
        if (advancedSearchPanelComponent == null) {
            advancedSearchPanelComponent = new AdvancedSearchPanelComponent(driver);
        }
        return advancedSearchPanelComponent;
    }

    public PaginationComponent getPaginationComponent() {
        if (paginationComponent == null) {
            paginationComponent = new PaginationComponent(driver);
        }
        return paginationComponent;
    }

    public PaginationComponent openPaginationComponent() {
        return getPaginationComponent().waitForPaginationComponentToOpen();
    }

    public ListCardViewComponent getListCardViewComponent() {
        if (listCardViewComponent == null) {
            listCardViewComponent = new ListCardViewComponent(driver);
        }
        return listCardViewComponent;
    }

    public BlockCardViewComponent getBlockCardViewComponent() {
        if (blockCardViewComponent == null) {
            blockCardViewComponent = new BlockCardViewComponent(driver);
        }
        return blockCardViewComponent;
    }

    public SortClubComponent getSortClubComponent() {
        if (sortClubComponent == null) {
            sortClubComponent = new SortClubComponent(driver);
        }
        return sortClubComponent;
    }

    public CardComponent getClubPageComponent() {
        if (clubPageComponent == null) {
            clubPageComponent = new CardComponent(driver);
        }
        return clubPageComponent;
    }

    public WebElement getAdvancedSearchButton() {
        waitVisibilityOfElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        if (advancedSearchButton == null) {
            advancedSearchButton = driver.findElement(By.xpath("//span[contains(@class, 'anticon-control')]"));
        }
        return advancedSearchButton;
    }

    public AdvancedSearchPanelComponent clickAdvancedSearchButton() {
        getAdvancedSearchButton().click();
        return getAdvancedSearchPanelComponent();
    }
    public boolean getPageIdentity(){
        try {
            pageIdentifier = driver.findElement(By.xpath("//section[@class='ant-layout club-list']"));
        } catch (Exception e){
            return false;
        }
        return true;
    }

}
