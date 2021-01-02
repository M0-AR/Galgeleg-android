package com.example.galgeleg.version_01.factory_word;

import com.example.galgeleg.version_01.data.GoogleSheetData;
import com.example.galgeleg.version_01.data.MemoryData;
import com.example.galgeleg.version_01.data.WebsiteData;

public class DataFactory {

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
