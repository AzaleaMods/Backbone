package dev.jade.backbone.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static dev.jade.backbone.BackboneMod.HEAVY_MATERIALS;

@Mixin(ArmorItem.class)
public class ArmorItemMixin {

    @WrapOperation(method = "method_56689", at = @At(value = "INVOKE", target = "Lnet/minecraft/component/type/AttributeModifiersComponent$Builder;build()Lnet/minecraft/component/type/AttributeModifiersComponent;"))
    private static AttributeModifiersComponent backbone$slowWalkSpeedInHeavyArmor(AttributeModifiersComponent.Builder instance, Operation<AttributeModifiersComponent> original, @Local(argsOnly = true) RegistryEntry<ArmorMaterial> material, @Local(argsOnly = true) ArmorItem.Type type) {

        if(!HEAVY_MATERIALS.containsKey(material)) return original.call(instance);

        AttributeModifierSlot slot = AttributeModifierSlot.forEquipmentSlot(type.getEquipmentSlot());
        Identifier id = Identifier.ofVanilla("armor." + type.getName());

        instance.add(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                new EntityAttributeModifier(
                        id,
                        HEAVY_MATERIALS.get(material) / 4.0, /*
                                                                 We divide by 4.0 here to make sure that the correct
                                                                 bonus is applied when the FULL set of armor is on,
                                                                 rather than once per piece (way too much) :]
                                                                */
                        EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                ),
                slot
        );

        return instance.build();

    }

}
