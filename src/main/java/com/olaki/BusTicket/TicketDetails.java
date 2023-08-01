package com.olaki.BusTicket;

public class TicketDetails {

    private String ticketNumber;
    private String busNumber;
    private String seatNumber;
    private String confirmedDate;
    private String fromCity;
    private String toCity;
    private String fare;

    public TicketDetails() {

    }

    public TicketDetails(String ticketNumber, String busNumber, String seatNumber, String confirmedDate, String fromCity, String toCity, String fare) {
        this.ticketNumber = ticketNumber;
        this.busNumber = busNumber;
        this.seatNumber = seatNumber;
        this.confirmedDate = confirmedDate;
        this.fromCity = fromCity;
        this.toCity = toCity;
        this.fare = fare;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getConfirmedDate() {
        return confirmedDate;
    }

    public void setConfirmedDate(String confirmedDate) {
        this.confirmedDate = confirmedDate;
    }

    public String getFromCity() {
        return fromCity;
    }

    public void setFromCity(String fromCity) {
        this.fromCity = fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getFare() {
        return fare;
    }

    public void setFare(String fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "TicketDetails{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", busNumber='" + busNumber + '\'' +
                ", seatNumber='" + seatNumber + '\'' +
                ", confirmedDate='" + confirmedDate + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", fare='" + fare + '\'' +
                '}';
    }
}
