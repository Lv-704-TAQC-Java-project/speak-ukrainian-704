package pages.clubs;

import org.openqa.selenium.*;
import pages.BasePage;
import pages.header.HeaderComponent;
import java.util.ArrayList;
import java.util.List;


public class ClubsPage extends BasePage {
    private PaginationComponent paginationComponent;

    private WideCardComponent wideCardComponent;
    private BlockCardComponent blockCardComponent;

    private SortClubComponent sortClubComponent;
    private CardComponent cardComponent;
    private AdvancedSearchPanelComponent advancedSearchPanelComponent;
    private WebElement advancedSearchButton;
    private HeaderComponent header;
    private WebElement pageIdentifier;
    private WebElement headerTitle;

    List<CardComponent> cards;
    List<CenterComponent> centers;

    private List<WebElement> getCardsBody() {
        return driver.findElements(By.xpath("//div[contains(@class, 'card-body')]"));
    }

    public List<CardComponent> getCards() {
        this.cards = new ArrayList<>();
        for (WebElement card : getCardsBody()) {
            this.cards.add(new CardComponent(driver, card));
        }
        return this.cards;
    }

    public List<CenterComponent> getCenters() {
        this.centers = new ArrayList<>();
        for (WebElement card : getCardsBody()) {
            this.centers.add(new CenterComponent(driver, card));
        }
        return this.centers;
    }

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getHeaderTitle() {
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

    public WideCardComponent getWideCardComponent() {
        if (wideCardComponent == null) {
            wideCardComponent = new WideCardComponent(driver);
        }
        return wideCardComponent;
    }

    public BlockCardComponent getBlockCardComponent() {
        if (blockCardComponent == null) {
            blockCardComponent = new BlockCardComponent(driver);
        }

        return blockCardComponent;
    }

    public SortClubComponent getSortClubComponent() {
        if (sortClubComponent == null) {
            sortClubComponent = new SortClubComponent(driver);
        }
        return sortClubComponent;
    }

    public CardComponent getCardComponent() {
        if (cardComponent == null) {
            cardComponent = new CardComponent(driver);
        }
        return cardComponent;
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

    public boolean clubsNotFoundMessageVisible() {
        return driver.findElement(By.xpath("//div[@class='clubs-not-found']")).isDisplayed();
    }

    public String clubsNotFoundMessage() {
        return driver.findElement(By.xpath("//div[@class='clubs-not-found']")).getText();
    }

}
