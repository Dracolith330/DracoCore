package dracocore.blocks.blockclasses.power;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;
import dracocore.blocks.blockclasses.power.machines.StoneSmasher;
import dracocore.blocks.blockclasses.power.wire.HighGradeWire;
import dracocore.blocks.blockclasses.power.wire.LowGradeWire;
import dracocore.blocks.blockclasses.power.wire.MediumGradeWire;
import dracocore.blocks.blockclasses.power.wire.PerfectGradeWire;

public class BlocksTech 
{
			//EARLY GAME//
	public static Block StoneSmasher;
	public static Block BrickMover;
	public static Block PneumaticLogger;
	public static Block ManualWireStringer;
	public static Block PneumaticHarvester;
	
			//LATE GAME//
	public static Block MechanizedMoleHouse;
	public static Block StaticChargingStation;
	public static Block ElectricFlashburner;
	public static Block ElectroMagneticResonator;
	public static Block ElectricResonancechamber;
	public static Block TheChainVeyor;
	public static Block VaccumStringer;
	
			//WIRE//
	public static Block LowGradeWire;
	public static Block MediumGradeWire;
	public static Block HighGradeWire;
	public static Block PerfectGradeWire;
	
	public static void init()
	{

		StoneSmasher = new StoneSmasher().setBlockName("StoneSmasher");
		GameRegistry.registerBlock(StoneSmasher, StoneSmasher.getUnlocalizedName().substring(5));
		
		/*
		BrickMover = new BrickMover().setBlockName("BrickMover");
		GameRegistry.registerBlock(BrickMover, BrickMover.getUnlocalizedName().substring(5));
		
		PneumaticLogger = new PneumaticLogger().setBlockName("PneumaticLogger");
		GameRegistry.registerBlock(PneumaticLogger, PneumaticLogger.getUnlocalizedName().substring(5));
		
		ManualWireStringer = new ManualWireStringer().setBlockName("ManualWireStringer");
		GameRegistry.registerBlock(ManualWireStringer, ManualWireStringer.getUnlocalizedName().substring(5));
		
		PneumaticHarvester = new PneumaticHarvester().setBlockName("PneumaticHarvester");
		GameRegistry.registerBlock(PneumaticHarvester, PneumaticHarvester.getUnlocalizedName().substring(5));
		
		MechanizedMoleHouse = new MechanizedMoleHouse().setBlockName("MechanizedMoleHouse");
		GameRegistry.registerBlock(MechanizedMoleHouse, MechanizedMoleHouse.getUnlocalizedName().substring(5));
		
		StaticChargingStation = new StaticChargingStation().setBlockName("StaticChargingStation");
		GameRegistry.registerBlock(StaticChargingStation, StaticChargingStation.getUnlocalizedName().substring(5));
		
		ElectricFlashburner = new ElectricFlashburner().setBlockName("ElectricFlashburner");
		GameRegistry.registerBlock(ElectricFlashburner, ElectricFlashburner.getUnlocalizedName().substring(5));
		
		ElectroMagneticResonator = new ElectroMagneticResonator().setBlockName("ElectroMagneticResonator");
		GameRegistry.registerBlock(ElectroMagneticResonator, ElectroMagneticResonator.getUnlocalizedName().substring(5));
		
		ElectricResonancechamber = new ElectricResonancechamber().setBlockName("ElectricResonancechamber");
		GameRegistry.registerBlock(ElectricResonancechamber, ElectricResonancechamber.getUnlocalizedName().substring(5));
		
		TheChainVeyor = new TheChainVeyor().setBlockName("TheChainVeyor");
		GameRegistry.registerBlock(TheChainVeyor, TheChainVeyor.getUnlocalizedName().substring(5));
		
		VaccumStringer = new VaccumStringer().setBlockName("VaccumStringer");
		GameRegistry.registerBlock(VaccumStringer, VaccumStringer.getUnlocalizedName().substring(5));
		*/
		
		LowGradeWire = new LowGradeWire().setBlockName("LowGradeWire");
		GameRegistry.registerBlock(LowGradeWire, LowGradeWire.getUnlocalizedName().substring(5));
		
		MediumGradeWire = new MediumGradeWire().setBlockName("MediumGradeWire");
		GameRegistry.registerBlock(MediumGradeWire, MediumGradeWire.getUnlocalizedName().substring(5));
		
		HighGradeWire = new HighGradeWire().setBlockName("HighGradeWire");
		GameRegistry.registerBlock(HighGradeWire, HighGradeWire.getUnlocalizedName().substring(5));
		
		PerfectGradeWire = new PerfectGradeWire().setBlockName("PerfectGradeWire");
		GameRegistry.registerBlock(PerfectGradeWire, PerfectGradeWire.getUnlocalizedName().substring(5));
		
	}
}
