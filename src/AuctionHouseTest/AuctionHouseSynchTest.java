package AuctionHouseTest;

import AuctionHouse.AuctionHouse;
import AuctionHouse.ItemInfo;
import SourcesToOrganize.Bid;

import static SourcesToOrganize.AgentApp.auctionPort;
import static SourcesToOrganize.AgentApp.bankPort;

public class AuctionHouseSynchTest {

    public static void main(String[] args) {

        System.out.println("Starting... ");
        AuctionHouse auction = new AuctionHouse(auctionPort, "localhost", bankPort);

        System.out.println("Created, now printing");
        for (ItemInfo item : auction.getItems()) {
            System.out.println(item);
        }

        ItemInfo item = auction.getItemInfo(1000);
        while (item.getPrice() < 1000) {
            Bid bid = new Bid(item.getPrice()+5, item.getItemID(), item.getItemID());
            auction.bid(bid);

            item = auction.getItemInfo(1000);
        }


    }
}
