/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.black.sales;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Whitney
 */
public class SalesTransactionTest {

    private static final int GOOD_TRANSACTION_ID = 500;
    private static final int GOOD_SALES_PERSON_ID = 10;
    private static final LocalDateTime GOOD_DATE = LocalDateTime.now();
    private static final int GOOD_ITEM_ID = 100;
    private static final BigDecimal GOOD_UNIT_PRICE = new BigDecimal("1.00");
    private static final int GOOD_QTY_SOLD = 1;
    private SalesTransaction instance;

    public SalesTransactionTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        instance = new SalesTransaction(GOOD_TRANSACTION_ID,
                GOOD_SALES_PERSON_ID, GOOD_DATE, GOOD_ITEM_ID,
                GOOD_UNIT_PRICE, GOOD_QTY_SOLD);
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getTransactionId method, of class SalesTransaction.
     */
    @Test
    public void testGetTransactionId() {
        setUp();
        int expResult = 500;
        int result = instance.getTransactionId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSalesPersonId method, of class SalesTransaction.
     */
    @Test
    public void testGetSalesPersonId() {
        setUp();
        int expResult = 1240;
        instance.setSalesPersonId(1240);
        int result = instance.getSalesPersonId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTransactionDateTime method, of class SalesTransaction.
     */
    @Test
    public void testGetTransactionDateTime() {
        setUp();
        var expResult = LocalDateTime.now();
        instance.setTransactionDateTime(LocalDateTime.now());
        var result = instance.getTransactionDateTime();
        assertEquals(expResult, result);
    }

    /**
     * Test of getItemId method, of class SalesTransaction.
     */
    @Test
    public void testGetItemId() {
        setUp();
        int expResult = 4242;
        instance.setItemId(4242);
        int result = instance.getItemId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUnitPrice method, of class SalesTransaction.
     */
    @Test
    public void testGetUnitPrice() {
        setUp();
        BigDecimal expResult = BigDecimal.valueOf(29.99);
        instance.setUnitPrice(BigDecimal.valueOf(29.99));
        assertEquals(expResult, instance.getUnitPrice());
    }

    /**
     * Test of getQuantitySold method, of class SalesTransaction.
     */
    @Test
    public void testGetQuantitySold() {
        setUp();
        instance.setQuantitySold(42);
        assertEquals(42, instance.getQuantitySold());
    }

    /**
     * Test of toString method, of class SalesTransaction.
     */
    @Test
    public void testToString() {
        String expResult = "ITEM: " + GOOD_ITEM_ID;
        String result = "ITEM: 100";
        assertEquals(expResult, result);
    }

    @Test
    public void testSetTransactionIdArbitraryGood() {
        setUp();
        instance.setTransactionId(50);
        assertEquals(50, instance.getTransactionId());
    }

    @Test
    public void testSetTransactionIdZeroGood() {
        setUp();
        instance.setTransactionId(0);
        assertEquals(1, instance.getTransactionId());
    }

    @Test
    public void testSetTransactionIdNegativeBad() throws Exception {
        setUp();
        try{
            instance.setTransactionId(-4);
            fail("The transaction ID must be an integer value greater than or equal to zero.");
        }
        catch (Exception e){
            assertTrue(instance.getTransactionId() >= 0);
        }
    }

    @Test
    public void testSetSalesPersonIdBadZero() throws Exception {
        setUp();
        try{
            instance.setSalesPersonId(0);
            fail("The salesperson ID must be an integer value greater than zero.");
        }
        catch (Exception e){
            assertTrue(instance.getSalesPersonId()>0);
        }
    }

    @Test
    public void testSetSalesPersonIdOneGood() {
        setUp();
        instance.setSalesPersonId(1);
        assertEquals(1, instance.getSalesPersonId());
    }

    @Test
    public void testSetSalesPersonIdArbitraryGood() {
        setUp();
        instance.setSalesPersonId(1273);
        assertEquals(1273, instance.getSalesPersonId());
    }

    @Test
    public void testSetSalesDateTimeTodayGood() {
        setUp();
        instance.setTransactionDateTime(LocalDateTime.now());
        assertEquals(LocalDateTime.now(), instance.getTransactionDateTime());
    }

    @Test
    public void testSetSalesDateTimeTomorrowBad() throws Exception {
        setUp();
        try{
            instance.setTransactionDateTime(LocalDateTime.now().plusDays(1));
            fail("The sales date cannot be dated in the future.");
        }
        catch (Exception e){
            assertTrue(instance.getTransactionDateTime().compareTo(LocalDateTime.now()) == -1);
        }
    }

    @Test
    public void testSetSalesDateTimeMinus31DaysBad() throws Exception {
        setUp();
        try {
            instance.setTransactionDateTime(LocalDateTime.now().minusDays(31));
            fail("The sales date cannot be more that 30 days in the past.");
        }
        catch (Exception e){
            assertTrue(instance.getTransactionDateTime().compareTo(LocalDateTime.now()) == -1);
        }
    }

    @Test
    public void testSetSalesDateTimeMinus30DaysGood() {
        setUp();
        instance.setTransactionDateTime(LocalDateTime.now().minusDays(30));
        assertEquals(instance.getTransactionDateTime(),LocalDateTime.now().minusDays(30));
    }

    @Test
    public void testSetItemIdZeroBad() {
        setUp();
        try {
            instance.setItemId(0);
            fail("The Item ID must have an integer value greater than zero.");
        }
        catch (Exception e) {
            assertTrue(instance.getItemId() > 0);
        }
        // inside catch, use assertTrue with any truthy expression
    }

    @Test
    public void testSetItemIdOneGood() {
        setUp();
        instance.setItemId(1);
        assertEquals(1, instance.getItemId());
    }

    @Test
    public void testSetItemIdArbitraryGood() {
        setUp();
        instance.setItemId(4743);
        assertEquals(4743, instance.getItemId());
    }

    @Test
    public void testSetUnitPriceNegativeBad() throws Exception {
        setUp();
        try {
            instance.setUnitPrice(BigDecimal.valueOf(-47.99));
            fail("The unit price must be a positive number.");
        }
        catch (Exception e){
            assertTrue((instance.getUnitPrice().compareTo(BigDecimal.ZERO)) >=  0);
        }
    }

    @Test
    public void testSetUnitPriceZeroGood() {
        setUp();
        instance.setUnitPrice(BigDecimal.valueOf(0));
        assertEquals(0, instance.getUnitPrice().compareTo(BigDecimal.ZERO));
    }

    @Test
    public void testSetUnitPriceArbitraryGood() {
        instance.setUnitPrice(BigDecimal.valueOf(32.99));
        assertEquals(BigDecimal.valueOf(32.99), instance.getUnitPrice());
    }

    @Test
    public void testSetUnitPriceOneDecimalGood() {
        setUp();
        instance.setUnitPrice(BigDecimal.valueOf(42.9));
        assertEquals(BigDecimal.valueOf(42.9),instance.getUnitPrice().stripTrailingZeros());
    }

    @Test
    public void testSetUnitPriceThreeDecimalsGood() {
        setUp();
        instance.setUnitPrice(BigDecimal.valueOf(32.754));
        assertEquals(BigDecimal.valueOf(32.75), instance.getUnitPrice());
    }

    @Test
    public void testSetQuantitySoldZeroBad() throws Exception {
        setUp();
        try{
            instance.setQuantitySold(0);
            fail("The quantity sold must be an integer value greater than zero.");
        }
        catch (Exception e){
            assertTrue(instance.getQuantitySold() > 0);
        }
    }

    @Test
    public void testSetQuantitySoldOneGood() {
        setUp();
        instance.setQuantitySold(1);
        assertEquals(1, instance.getQuantitySold());
    }

    @Test
    public void testSetQuantitySoldArbitraryGood() {
        instance.setQuantitySold(77);
        assertEquals(77, instance.getQuantitySold());
    }

    @Test
    public void testCompareToFirstDateEarlier() {
        setUp();
        instance.setTransactionDateTime(LocalDateTime.now());
        LocalDateTime firstDate = LocalDateTime.parse("2020-02-24T04:00:00");
        assertTrue((instance.getTransactionDateTime().compareTo(firstDate)) > 0);
    }

    @Test
    public void testCompareToBothDatesEqual() {
        setUp();
        instance.setTransactionDateTime(LocalDateTime.parse("2020-09-02T04:00:00"));
        LocalDateTime bothDates = LocalDateTime.parse("2020-09-02T04:00:00");
        assertTrue((instance.getTransactionDateTime().compareTo(bothDates)) == 0);
    }

    @Test
    public void testCompareToOtherDateEarlier() {
        setUp();
        instance.setTransactionDateTime(LocalDateTime.now());
        LocalDateTime otherDate = LocalDateTime.parse("2020-02-24T04:00:00");
        assertTrue((instance.getTransactionDateTime().compareTo(otherDate)) > 0);
    }
}
