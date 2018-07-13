package me.myProjects.microservice.core.export.conversion;

import com.univocity.parsers.conversions.Conversion;

public class Fen2YuanConversion implements Conversion<Long, String> {

    @Override
    public String execute(Long aLong) {
        return null;
    }

    @Override
    public Long revert(String o) {
        return null;
    }

}
