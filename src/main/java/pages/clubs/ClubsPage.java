package pages.clubs;

import org.openqa.selenium.*;
import pages.BasePage;
import pages.clubs.card.components.BlockCardComponent;
import pages.clubs.card.components.CardComponent;
import pages.clubs.card.components.CenterComponent;
import pages.clubs.card.components.WideCardComponent;
import pages.header.HeaderComponent;

import java.util.ArrayList;
import java.util.List;


public class ClubsPage extends BasePage {
    private PaginationComponent paginationComponent;
    private WebElement blockCardContainer;
    private WebElement listCardContainer;
    private SortClubComponent sortClubComponent;
    private BlockCardComponent cardComponent;
    private AdvancedSearchPanelComponent advancedSearchPanelComponent;
    private ExpandedCardComponent expandedCardComponent;
    private WebElement advancedSearchButton;
    private HeaderComponent header;
    private WebElement pageIdentifier;
    private WebElement headerTitle;
    private List<CardComponent> cards;
    private List<BlockCardComponent> blockCards;
    private List<WideCardComponent> wideCards;
    private List<CenterComponent> centers;
    private List<WebElement> paginationComponents;

    public ClubsPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getCardsBody() {
        return driver.findElements(By.xpath(".//div[contains(@class, 'card-body')]"));
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

    public WebElement getHeaderTitle() {
        return driver.findElement(By.xpath("//h2[@class='city-name']"));
    }

    public String headerTitleText() {
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

    public ExpandedCardComponent getExpandedCardComponent() {
        if (expandedCardComponent == null) {
            expandedCardComponent = new ExpandedCardComponent(driver);
        }
        return expandedCardComponent;
    }

    public PaginationComponent getPaginationComponent() {
        if (paginationComponent == null) {
            paginationComponent = new PaginationComponent(driver);
        }
        return paginationComponent;
    }

    public List<WebElement> getPaginationComponents() {
        paginationComponents = driver.findElements(By.xpath("//ul[@class='ant-pagination pagination']/li"));
        return paginationComponents;
    }

    public boolean paginationComponentIsVisible(){
        return getPaginationComponents().size() > 0;
    }

    public PaginationComponent openPaginationComponent() {
        return getPaginationComponent().waitForPaginationComponentToOpen();
    }

    public SortClubComponent getSortClubComponent() {
        if (sortClubComponent == null) {
            sortClubComponent = new SortClubComponent(driver);
        }
        return sortClubComponent;
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

    public WebElement getBlockCardContainer() {
        if (blockCardContainer == null) {
            blockCardContainer = driver.findElement(By.xpath("//div[@class = 'content-clubs-list content-clubs-block']"));
//            blockCardContainer.findElement(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card']"));
        }
        return blockCardContainer;
    }

    public WebElement getWideCardContainer() {
        if (listCardContainer == null) {
            listCardContainer = driver.findElement(By.xpath("//div[@class = 'content-clubs-list false']"));
//            listCardContainer.findElement(By.xpath("//div/div[@class = 'ant-card ant-card-bordered card list-rectangle-item']"));
        }
        return listCardContainer;
    }

}
