package cn.sd.yz.strategy;

public class NewCustomerManyStrategy implements Strategy {

	@Override
	public double getPrice(double standardPrince) {
		System.out.println("打9折");
		return standardPrince*0.9;
	}

}