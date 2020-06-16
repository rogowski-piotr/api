package com.piotr.api;


/**
 * @JsonObiect represents an object of the server's response
 */
public class JsonObiect {

    private final String abbreviation;
    private final String client_ip;
    private final String datetime;
    private final int day_of_week;
    private final int day_of_year;
    private final boolean dst;
    private final String dst_from;
    private final int dst_offset;
    private final String dst_until;
    private final int raw_offset;
    private final String timezone;
    private final int unixtime;
    private final String utc_datetime;
    private final String utc_offset;
    private final int week_number;

    public String getDatetime() {
        return datetime;
    }

    JsonObiect(String abbreviation, String client_ip, String datetime, int day_of_week, int day_of_year, boolean dst, String dst_from, int dst_offset, String dst_until, int raw_offset, String timezone, int unixtime, String utc_datetime, String utc_offset, int week_number) {
        this.abbreviation = abbreviation;
        this.client_ip = client_ip;
        this.datetime = datetime;
        this.day_of_week = day_of_week;
        this.day_of_year = day_of_year;
        this.dst = dst;
        this.dst_from = dst_from;
        this.dst_offset = dst_offset;
        this.dst_until = dst_until;
        this.raw_offset = raw_offset;
        this.timezone = timezone;
        this.unixtime = unixtime;
        this.utc_datetime = utc_datetime;
        this.utc_offset = utc_offset;
        this.week_number = week_number;
    }
}
