package com.practice.automation.junit;

import org.junit.Assert;
import org.junit.Test;

import com.sample.framework.ui.PageFactory;
import com.sample.tests.pages.SignInPage;
import com.sample.tests.pages.ViewDressPage;
import com.sample.tests.pages.WomenPage;

public class MyStoreUITest extends TestCommon{
	
	public void MyStoreUITest() {
		
	}
	
	@Test
	public void HomePageUITest() {
		Assert.assertTrue(homePage.signinLink.exists());
		Assert.assertTrue(homePage.menuLinkWomen.exists());
		Assert.assertTrue(homePage.menuLinkDresses.exists());
		Assert.assertTrue(homePage.menuLinkTshirts.exists());
		Assert.assertTrue(homePage.cartAlertTextInfo.exists());
		Assert.assertTrue(homePage.homePopularItemsBlock.exists());
		Assert.assertTrue(homePage.bestSellersItemsBlock.exists());
		homePage.signinLink.click();
	}
	/*
	
	@Test
	public void SignInPageUITest() throws Exception {
		loginPage=PageFactory.init(SignInPage.class);
		Assert.assertTrue(homePage.signinLink.exists());
		Assert.assertTrue(loginPage.email.exists());
		Assert.assertTrue(loginPage.password.exists());
		Assert.assertTrue(loginPage.submitButton.exists());
		homePage.menuLinkWomen.click();
	}
	
	@Test
	public void WomenPageUITest() throws Exception {
		womenPage=PageFactory.init(WomenPage.class);

		Assert.assertTrue(womenPage.colorOption.exists());
		Assert.assertTrue(womenPage.blockProduct.exists());
		Assert.assertTrue(womenPage.allSpecialsLink.exists());
		Assert.assertTrue(womenPage.specialProductsList.exists());
		Assert.assertTrue(womenPage.pickColorLisItem.exists());
		womenPage.blockProduct.click();
	}

	@Test
	public void ViewDressPageUITest() throws Exception{
		viewDressPage=PageFactory.init(ViewDressPage.class);
		Assert.assertTrue(viewDressPage.colorCheckbox.exists());
		Assert.assertTrue(viewDressPage.addToCartButton.exists());
		Assert.assertTrue(viewDressPage.continueShoppingOption.exists());
		Assert.assertTrue(viewDressPage.signoutLink.exists());
		Assert.assertTrue(viewDressPage.cartStatus.exists());
	}
*/

}
