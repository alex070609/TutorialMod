package net.bacchus.tutorialmod.item;

import net.bacchus.tutorialmod.TutorialMod;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    SAPPHIRE(
            "sapphire",
            26,
            new int[]{ 5, 7, 5, 4 },
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            1f,
            0f,
            () -> Ingredient.of(ModItems.SAPPHIRE.get()));

    private final String name;
    private final int durabilityMultiplayer;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplayer, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {

        this.name = name;
        this.durabilityMultiplayer = durabilityMultiplayer;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplayer;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return TutorialMod.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
