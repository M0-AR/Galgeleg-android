package com.example.galgeleg.factory;

import com.example.galgeleg.data.GoogleSheetData;
import com.example.galgeleg.data.MemoryData;
import com.example.galgeleg.data.WebsiteData;

public class WordFactory {

    public Word makeData(int newDataType) {
        switch (newDataType) {
            case 0:
                return new MemoryData();
            case 1:
                return new GoogleSheetData();
            case 2:
                return new WebsiteData();
            default:
                return null;
        }
    }
}
