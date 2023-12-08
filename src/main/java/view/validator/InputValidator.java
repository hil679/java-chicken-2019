package view.validator;

public class InputValidator {
    public void checkMainFeatures(int mainFeatureNum){
        if(isNotMainFeatureNum(mainFeatureNum)) {
            throw new IllegalArgumentException("[ERROR] 메인 화면 기능 목록에 있는 숫자만 입력해주세요.");
        }
    }

    private boolean isNotMainFeatureNum(int mainFeatureNum) {
        return 1 <= mainFeatureNum && mainFeatureNum <= 3;
    }
}
