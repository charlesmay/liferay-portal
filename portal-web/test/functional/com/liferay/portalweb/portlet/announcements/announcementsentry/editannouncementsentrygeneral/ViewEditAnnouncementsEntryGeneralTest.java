/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portalweb.portlet.announcements.announcementsentry.editannouncementsentrygeneral;

import com.liferay.portalweb.portal.BaseTestCase;
import com.liferay.portalweb.portal.util.RuntimeVariables;

/**
 * @author Brian Wing Shun Chan
 */
public class ViewEditAnnouncementsEntryGeneralTest extends BaseTestCase {
	public void testViewEditAnnouncementsEntryGeneral()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/guest/home/");
		selenium.clickAt("link=Announcements Test Page",
			RuntimeVariables.replace("Announcements Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("link=Entries"));
		assertTrue(selenium.isVisible("link=Manage Entries"));
		assertEquals(RuntimeVariables.replace("Announcements Entry Title Edit"),
			selenium.getText("//h3[@class='entry-title']/a"));
		assertEquals(RuntimeVariables.replace("Edit"),
			selenium.getText("//td[@class='edit-entry']/span/a/span"));
		assertEquals(RuntimeVariables.replace("Delete"),
			selenium.getText("//td[@class='delete-entry']/span/a/span"));
		assertEquals(RuntimeVariables.replace("Mark as Read"),
			selenium.getText("//td[@class='control-entry']/a"));
		assertEquals(RuntimeVariables.replace("General"),
			selenium.getText("//span[@class='entry-scope']"));
		assertTrue(selenium.isPartialText(
				"//div[@class=' entry-content entry-type-general']",
				"Announcements Entry Content Edit"));
		selenium.clickAt("link=Manage Entries",
			RuntimeVariables.replace("Manage Entries"));
		selenium.waitForPageToLoad("30000");
		selenium.select("//select[@id='_84_distributionScope']",
			RuntimeVariables.replace("General"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isVisible("//input[@value='Add Entry']"));
		assertEquals(RuntimeVariables.replace("Announcements Entry Title Edit"),
			selenium.getText(
				"//tr[contains(.,'Announcements Entry Title Edit')]/td[1]/a"));
		assertEquals(RuntimeVariables.replace("General"),
			selenium.getText(
				"//tr[contains(.,'Announcements Entry Title Edit')]/td[2]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Announcements Entry Title Edit')]/td[3]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Announcements Entry Title Edit')]/td[4]/a"));
		assertTrue(selenium.isVisible(
				"//tr[contains(.,'Announcements Entry Title Edit')]/td[5]/a"));
		assertEquals(RuntimeVariables.replace("Actions"),
			selenium.getText(
				"//tr[contains(.,'Announcements Entry Title Edit')]/td[6]/span[@title='Actions']/ul/li/strong/a/span"));
		assertEquals(RuntimeVariables.replace("Showing 1 result."),
			selenium.getText("//div[@class='search-results']"));
	}
}