package me.mrsoulpenguin.cosdt.challenge;

import me.mrsoulpenguin.cosdt.challenge.goal.Goal;
import me.mrsoulpenguin.cosdt.challenge.event.Event;
import net.minecraft.util.ActionResult;

public class TimedChallenge extends Challenge implements TickingChallenge {

    private final long timeToCompleteMillis;
    private long startTime;

    public TimedChallenge(Goal goal, long timeToCompleteMillis, Event rewardEvent, Event punishmentEvent) {
        super(goal, rewardEvent, punishmentEvent);

        this.timeToCompleteMillis = timeToCompleteMillis;
    }

    @Override
    public void start() {
        this.startTime = System.currentTimeMillis();
        super.start();
    }

    public void tick() {
        if (System.currentTimeMillis() - this.startTime >= this.timeToCompleteMillis) {
            super.stop(ActionResult.FAIL);
        }
    }
}
