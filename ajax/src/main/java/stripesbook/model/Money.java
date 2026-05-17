package stripesbook.model;

public class Money {
	private int youGaveMe;
	private int andIGiveYou;
	
	public Money(int youGaveMe, int andIGiveYou) {
		this.youGaveMe = youGaveMe;
		this.andIGiveYou = andIGiveYou;
	}
	
	/* getters and setters... */
	public int getYouGaveMe() {
		return youGaveMe;
	}
	public void setYouGaveMe(int youGaveMe) {
		this.youGaveMe = youGaveMe;
	}
	public int getAndIGiveYou() {
		return andIGiveYou;
	}
	public void setAndIGiveYou(int andIGiveYou) {
		this.andIGiveYou = andIGiveYou;
	}
	
}
