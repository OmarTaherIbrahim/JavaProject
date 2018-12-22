package Data.Tests;

public abstract class Test implements Comparable{
	private int xp;
	private int xpcap;
	private int userlevel;
	public Test() {
		setxp(0);
		setxpcap(0);
		setlevel(0);
	}
	private void setxp(int xp) {
		this.xp = xp;
	}
	public int getxp() {
		return xp;
	}
	public void setlevel(int userlevel) {
		this.userlevel = userlevel;
	}
	public int getlevel() {
		return userlevel;
	}
	public void setxpcap(int xpcap) {
		this.xpcap = xpcap;
	}
	public int getxpcap() {
		return xpcap;
	}
	public void Addxp(int rightans) {
		xp += rightans;
	}
	public void compute() {
		xpcap = 300+(userlevel*userlevel*25);
		if(xp >= xpcap) {
			xp = 0;
			userlevel++;
			compute();
		}
	}
	
	public int compareTo(Test o) {
		if(this.userlevel == o.userlevel) 
			return 0;
		else if(this.userlevel > o.userlevel)
			return 1;
		else
			return -1;
	}
		
}

