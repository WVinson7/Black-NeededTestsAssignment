/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.black.sales;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

/**
 *
 * @author Whitney
 */
public class SalesTransaction implements Comparable<SalesTransaction> {

    private int transactionId;
    private int salesPersonId;
    private LocalDateTime transactionDateTime;
    private int itemId;
    private BigDecimal unitPrice;
    private int quantitySold;
    private static int transactionCount = 0;

    public SalesTransaction(int transactionId, int salesPersonId,
            LocalDateTime transactionDateTime, int itemId,
            BigDecimal unitPrice, int quantitySold) {
        setTransactionId(transactionId);
        setSalesPersonId(salesPersonId);
        setTransactionDateTime(transactionDateTime);
        setItemId(itemId);
        setUnitPrice(unitPrice);
        setQuantitySold(quantitySold);
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        validateTransactionId(transactionId);
        if (transactionId == 0) {
            this.transactionId = ++transactionCount;
        } else {
            this.transactionId = transactionId;
        }
    }

    private void validateTransactionId(int transactionId) {
        if (transactionId < 0) {
            throw new IllegalArgumentException("The transaction ID must be an "
                    + "integer value greater than or equal to zero.");
        }
    }

    public int getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(int salesPersonId) {
        validateSalesPersonId(salesPersonId);
        this.salesPersonId = salesPersonId;
    }

    private void validateSalesPersonId(int salesPersonId) {
        if (salesPersonId < 1) {
            throw new IllegalArgumentException("The salesperson ID must be an "
                    + "integer value greater than zero.");
        }
    }

    public LocalDateTime getTransactionDateTime() {
        return transactionDateTime;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        validateTransactionDateTime(transactionDateTime);
        this.transactionDateTime = transactionDateTime;
    }

    private void validateTransactionDateTime(LocalDateTime transactionDateTime) {
        if (transactionDateTime.isBefore(LocalDateTime.now().minusDays(30))) {
            throw new IllegalArgumentException("The sales date cannot be more "
                    + "than 30 days in the past");
        }
        if (transactionDateTime.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("The sales date cannot be dated "
                    + "in the future.");
        }
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        validateItemId(itemId);
        this.itemId = itemId;
    }

    private void validateItemId(int itemId) {
        if (itemId < 1) {
            throw new IllegalArgumentException("The Item ID must have an "
                    + "integer value greater than zero.");
        }
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        validateUnitPrice(unitPrice);
        this.unitPrice = unitPrice.setScale(2, RoundingMode.HALF_UP);
    }

    private void validateUnitPrice(BigDecimal unitPrice) {
        if (unitPrice.compareTo(new BigDecimal(0)) == -1) {
            throw new IllegalArgumentException("The unit price must be a "
                    + "positive decimal value.");
        }
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        validateQuantitySold(quantitySold);
        this.quantitySold = quantitySold;
    }

    private void validateQuantitySold(int quantitySold) {
        if (quantitySold < 1) {
            throw new IllegalArgumentException("The quantity sold must be an "
                    + "integer value greater than zero.");
        }
    }

    @Override
    public String toString() {
        return "SalesTransaction{" + "transactionId=" + transactionId
                + ", salesPersonId=" + salesPersonId + ", transactionDateTime="
                + transactionDateTime + ", itemId=" + itemId + ", unitPrice="
                + unitPrice + ", quantitySold=" + quantitySold + '}';
    }

    @Override
    public int compareTo(SalesTransaction other) {
        return transactionDateTime.compareTo(other.transactionDateTime);
    }
}
