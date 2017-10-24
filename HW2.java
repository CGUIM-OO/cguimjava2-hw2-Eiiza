import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author  B0544225陳勗恩
 * 1.輸入牌數(nDeck)
 * 2.deck:將牌數帶入實體化Deck類別
 * 3.再把deck帶入Deck類別裡的printDeck方法
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn= sc.nextLine(); 
        
		int nDeck=Integer.parseInt(testn);
		Deck deck=new Deck(nDeck);
		//TODO: please check your output, make sure that you print all cards on your screen (10 points)
		deck.printDeck();
		
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			System.out.println("Well done!");
		}else{
			System.out.println("Error, please check your sourse code");
		}
	}
	/**
	 * This method is used for checking your result, not a part of your HW2
	 * @param allCards �������
	 * @param nDeck 蝮賢��嗾����
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			int suit= card.getSuit();
			int rank = card.getRank();
			if(suit>4||suit<1||rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
/**
 * Deck是全部場上的排組
 * Deck類別包含3個method，Deck、printDeck、getAllCards;1個instance field，ArrayList<Card> cards
 * Deck method:是將有(nDeck)副牌全部跑出來， i=牌數 ; x=花色suit ; y=數字rank
 * printDeck method:是先get一個一個牌，然後轉用成 printCard method
 */
class Deck{
	private ArrayList<Card> cards;
	
	public Deck(int nDeck){
		cards=new ArrayList<Card>();
		//1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		//Hint: Use new Card(x,y) and 3 for loops to add card into deck
		//Sample code start
		//Card card=new Card(1,1); ->means new card as clubs ace
		//cards.add(card);
		//Sample code end
		for(int i=0;i<nDeck;i++){
			for(int x=1;x<5;x++){
				for(int y=1;y<14;y++){
					Card card=new Card(x,y);
					cards.add(card);
				}
			}
		}
	}	
	//TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck(){
		//Hint: print all items in ArrayList<Card> cards, 
		//TODO: please implement and reuse printCard method in Card class (5 points)
		int i=0;
		while(i<cards.size()){
			cards.get(i).printCard();
			i++;
		}
	}
	public ArrayList<Card> getAllCards(){
		return cards;
	}
}
/**
 * Card是定義一個牌長怎樣(藍圖)
 * Deck類別包含3個method，printCard、getSuit、getRank;2個instance field，suit、rank
 * printCard method:將數字轉換成英文
 */
class Card{
	private int suit; //Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; //1~13
	/**
	 * @param s suit
	 * @param r rank
	 */
	public Card(int s,int r){
		suit=s;
		rank=r;
	}	
	//TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10 for rank)
	public void printCard(){
		//Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as Clubs Ace
		if(suit==1){
			System.out.print("club ");
		}
		if(suit==2){
			System.out.print("diamond ");
		}
		if(suit==3){
			System.out.print("heart ");
		}
		if(suit==4){
			System.out.print("spade ");
		}
		if(rank==1){
			System.out.println("A");
		}
		if(rank==2){
			System.out.println("2");
		}
		if(rank==3){
			System.out.println("3");
		}
		if(rank==4){
			System.out.println("4");
		}
		if(rank==5){
			System.out.println("5");
		}
		if(rank==6){
			System.out.println("6");
		}
		if(rank==7){
			System.out.println("7");
		}
		if(rank==8){
			System.out.println("8");
		}
		if(rank==9){
			System.out.println("9");
		}
		if(rank==10){
			System.out.println("10");
		}
		if(rank==11){
			System.out.println("J");
		}
		if(rank==12){
			System.out.println("Q");
		}
		if(rank==13){
			System.out.println("K");
		}
	}
	public int getSuit(){
		return suit;
	}
	public int getRank(){
		return rank;
	}
}
