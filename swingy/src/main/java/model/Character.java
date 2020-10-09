package model;

import javax.validation.constraints.*;

public class Character {
        @NotNull
        @NotBlank(message = "Hero name must not be blank")
        private String			name;

        @NotNull
        @NotBlank(message = "Hero Race must not be blank")
        private String			race;
        private int             defence;
        private	int				healthPoints;
        private int				expPoints;
        private int				posX;
        private int				posY;
        private int				level;
        private int				attack;

        public Character() {
            name = null;
            race = null;
            healthPoints = 100;
            defence = 0;
            expPoints = 0;
            level = 1;
            attack = 5;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            this.race = race;
        }

        public int getHealthPoints() {
            return healthPoints;
        }

        public void setHealthPoints(int healthPoints) {
            this.healthPoints = healthPoints;
        }

        public int getExpPoints() {
            return expPoints;
        }

        public void setExpPoints(int expPoints) {
            this.expPoints = expPoints;
        }

        public int getPosX() {
            return posX;
        }

        public void setPosX(int posX) {
            this.posX = posX;
        }

        public int getPosY() {
            return posY;
        }

        public void setPosY(int posY) {
            this.posY = posY;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getAttack() {
            return attack;
        }

        public void setAttack(int attack) {
            this.attack = attack;
        }

        public void setDefence(int defence) {
            this.defence = defence;
        }

        public int getDefence() {
            return defence;
        }

        public void Armor(Enemy bad) {
            setDefence(this.getDefence() + 10 + (bad.getAttack() / 2));
        }

        public void Helmet(Enemy bad) {
            setHealthPoints(this.getHealthPoints() + 10 + (bad.getAttack() / 2));
        }

        public void Weapon(Enemy bad) {
            setAttack(this.getAttack() + 10 + (bad.getAttack() / 2));
        }
}
