//package party.application;
//
//public enum  PrintStyle {
//    FirstLast("-f"), LastFirst("-l");
//
//    private String option;
//
//    PrintStyle(String option) {
//
//        this.option = option;
//    }
//    public static PrintStyle parse(String option){
//        for (PrintStyle style : PrintStyle.values()) {
//            if(style.option == option)
//                return style;
//        }
//        return null;
//    }
//
//    public String represent(String first, String last) {
//        if(this == FirstLast)
//            return first +" "+last;
//    }
//}
