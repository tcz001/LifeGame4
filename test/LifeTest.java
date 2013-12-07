import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LifeTest {
    @Test
    public void should_return_next_frame_when_only_one_life() throws Exception {
        LifeFrame frame = new LifeFrame(new String[][]{{"*"}});
        LifeGame lifeGame = new LifeGame(frame);

        LifeFrame nextFrame = lifeGame.nextFrame();

        assertThat(nextFrame, is(frame));
    }

    @Test
    public void should_middle_alive_when_there_are_three_life_around() throws Exception {
        LifeFrame frame = new LifeFrame(new String[][]{{"*","*","*"},{" "," "," "}});
        LifeGame lifeGame = new LifeGame(frame);
        LifePosition lifePosition = new LifePosition(1,1);

        assertThat(lifeGame.shouldALive(lifePosition), is(LifeStatus.alive));
    }

    @Test
    public void should_middle_keep_alive_when_there_are_two_life_around() throws Exception {
        LifeFrame frame = new LifeFrame(new String[][]{{"*","*","*"},{" ","*"," "},{" "," "," "}});
        LifeGame lifeGame = new LifeGame(frame);
        LifePosition lifePosition = new LifePosition(1,1);

        assertThat(lifeGame.shouldALive(lifePosition), is(LifeStatus.alive));
    }

    @Test
    public void should_middle_dead_when_there_are_four_life_around() throws Exception {
        LifeFrame frame = new LifeFrame(new String[][]{{"*","*","*"},{" ","*"," "},{" ","*"," "}});
        LifeGame lifeGame = new LifeGame(frame);
        LifePosition lifePosition = new LifePosition(1,1);

        assertThat(lifeGame.shouldALive(lifePosition), is(LifeStatus.dead));
    }

    @Test
    public void should_middle_keep_dead_when_there_are_two_life_around() throws Exception {
        LifeFrame frame = new LifeFrame(new String[][]{{"*"," ","*"}});
        LifeGame lifeGame = new LifeGame(frame);
        LifePosition lifePosition = new LifePosition(1,1);

        assertThat(lifeGame.shouldALive(lifePosition), is(LifeStatus.dead));
    }

    @Test
    public void should_middle_alive_when_there_are_one_life_around() throws Exception {
        LifeFrame frame = new LifeFrame(new String[][]{{"*","*","*"}});
        LifeGame lifeGame = new LifeGame(frame);
        LifePosition lifePosition = new LifePosition(0,1);

        assertThat(lifeGame.shouldALive(lifePosition), is(LifeStatus.alive));
    }
}
