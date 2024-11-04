package org.openapijsonschematools.client.paths.reportsfilename.get.responses.code200response.content.textcsv;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.openapijsonschematools.client.components.schemas.Report;

public class TextcsvSchema2 extends Report {
    // $refed class
    
    
    public static class TextcsvSchema3 extends Report1 {
        private static @Nullable TextcsvSchema3 instance = null;
        public static TextcsvSchema3 getInstance() {
            if (instance == null) {
                instance = new TextcsvSchema3();
            }
            return instance;
        }
    }
}
