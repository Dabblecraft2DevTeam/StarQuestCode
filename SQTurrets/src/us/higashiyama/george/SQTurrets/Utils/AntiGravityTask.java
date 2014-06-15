
package us.higashiyama.george.SQTurrets.Utils;

import org.bukkit.entity.Arrow;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import us.higashiyama.george.SQTurrets.SQTurrets;
import us.higashiyama.george.SQTurrets.Turrets.APTurret;

public class AntiGravityTask extends BukkitRunnable {

	public AntiGravityTask() {

		runTaskTimer(SQTurrets.getInstance(), 1L, 1L);
	}

	public void run() {

		for (int i = 0; i < APTurret.arrowList.size(); i++) {
			if ((((Arrow) APTurret.arrowList.get(i)).isOnGround()) || (((Arrow) APTurret.arrowList.get(i)).getTicksLived() > 100)) {
				APTurret.arrowList.remove(i);
				i--;
			}
		}
		for (int i = 0; i < APTurret.arrowList.size(); i++) {
			Arrow a = (Arrow) APTurret.arrowList.get(i);
			if ((a.getLocation().getWorld().getName().equals("space")) || (a.getLocation().getWorld().getName().equals("AsteroidBelt"))) {
				Vector old = a.getVelocity();
				Vector grav = new Vector(0.0F, 0.05F, 0.0F);
				old = old.add(grav);
				old = old.multiply(1.25F);
				a.setVelocity(old);
			}
		}
	}

}