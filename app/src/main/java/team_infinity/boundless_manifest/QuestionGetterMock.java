package team_infinity.boundless_manifest;

/**
 * Created by Acer on 2018-01-08.
 * mock object implementation of QuestionGetterBase
 */
public class QuestionGetterMock implements QuestionGetterBase
{
    @Override
    public Question getQuestion()
    {
        String[] answers = {"sava", "pa", "pap", "despacito"};
        return new Question("apa", answers, 1);
    }
}
