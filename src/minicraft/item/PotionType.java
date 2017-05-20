package minicraft.item;

import minicraft.Game;
import minicraft.entity.Player;

public enum PotionType {
	None (5, 0),
	
	Speed (10, 4200) {
		public boolean toggleEffect(Player player, boolean addEffect) {
			player.moveSpeed += (double)( addEffect ? 1 : (player.moveSpeed > 1 ? -1 : 0) );
			return true;
		}
	},
	
	Light (440, 6000),
	Swim (3, 4800),
	Energy (510, 8400),
	Regen (464, 1800),
	
	Time (222, 1800) {
		public boolean toggleEffect(Player player, boolean addEffect) {
			Game.gamespeed *= (addEffect ? 0.5f : 2);
			return true;
		}
	},
	
	Lava (400, 7200),
	Shield (115, 5400),
	Haste (303, 4800);
	
	public int dispColor, duration;
	public String name;
	
	private PotionType(int col, int dur) {
		dispColor = col;
		duration = dur;
		if(this.toString().equals("None")) name = "Potion";
		else name = this + " Potion";
	}
	
	public boolean toggleEffect(Player player, boolean addEffect) {
		return true;
	}
}