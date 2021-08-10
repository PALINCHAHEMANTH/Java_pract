package demoPack.additional;

public class CompoundInterestBean 
{
	float years;
	float principal;
	double rate;
	double time;

	public float getYears() {
		return years;
	}
	public void setYears(float years) {
		this.years = years;
	}
	public float getPrincipal() {
		return principal;
	}
	public void setPrincipal(float principal) {
		this.principal = principal;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public float calculate() {
		return (float) ((principal * (Math.pow(1 + (rate / 100), years))) - 1);
	}
	public float getInterest() {
		return calculate();
	}
}