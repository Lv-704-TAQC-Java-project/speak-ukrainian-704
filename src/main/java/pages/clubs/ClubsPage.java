package pages.clubs;

import org.openqa.selenium.*;
import pages.BasePage;
import pages.header.HeaderComponent;

import java.util.ArrayList;
import java.util.List;


public class ClubsPage extends BasePage {
    private PaginationComponent paginationComponent;

    private WideCardComponent listCardViewComponent;
    private BlockCardComponent blockCardViewComponent;

    private SortClubComponent sortClubComponent;
    private CardComponent clubPageComponent;
    private AdvancedSearchPanelComponent advancedSearchPanelComponent;
    private WebElement advancedSearchButton;
    private HeaderComponent header;
    private WebElement pageIdentifier;
    private WebElement headerTitle;

    List<CardComponent> cards;

    public List<CardComponent> getCards() {
        List<WebElement> cards = driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
        this.cards = new ArrayList<>();
        for (WebElement card : cards) {
            this.cards.add(new CardComponent(driver, card));
        }
        return this.cards;
    }

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderTitle() {
        waitVisibilityOfElement(By.xpath("//h2[@class='city-name']"));
        return driver.findElement(By.xpath("//h2[@class='city-name']"));
    }

    public String readHeaderTitle() {
        return getHeaderTitle().getText();
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

    public WideCardComponent getListCardViewComponent() {
        if (listCardViewComponent == null) {
            listCardViewComponent = new WideCardComponent(driver);
        }
        return listCardViewComponent;
    }

    public BlockCardComponent getBlockCardViewComponent() {
        if (blockCardViewComponent == null) {
            blockCardViewComponent = new BlockCardComponent(driver);
        }

        return blockCardViewComponent;
    }

    public SortClubComponent getSortClubComponent() {
        if (sortClubComponent == null) {
            sortClubComponent = new SortClubComponent(driver);
        }
        return sortClubComponent;
    }

    public CardComponent getCardComponent() {
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

    public boolean getPageIdentity() {
        try {
            pageIdentifier = driver.findElement(By.xpath("//section[@class='ant-layout club-list']"));
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
