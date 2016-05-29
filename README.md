# CalHub
Super simple Minecraft server network hub plugin for Bukkit/Spigot/Paper

Currently does the following:
+ Prevents build/destroy with bypass permissions
+ Prevents dropping/picking up items with bypass permissions
+ Prevents bucket use with bypass permissions
+ Provides custom join, leave, and death messages
+ Spawn management (/setspawn, /spawn)
+ TP to spawn after falling into the void
+ Disables weather changes (can be disabled in the config)
+ Configurable MOTD on join
+ Option to clear chat on join 
+ Option to disable water/lava flow
+ Option to disable "fading" (ice melt, leaf decay, etc.)

Commands:
+ /spawn - Teleports the user to the world spawn
+ /setspawn - Sets the world spawn point the user's current location
+ /motd - Displays the configured Message Of The Day

Permission nodes (unless otherwise stated, defaults to "op"):
+ calhub.canplace
+ calhub.canbreak
+ calhub.canbucket
+ calhub.candrop
+ calhub.canpickup
+ calhub.spawn ("true" by default)
+ calhub.setspawn
+ calhub.motd ("true" by default)

ToDo/Requested:
+ Option to disable growth and trampling
+ Option to have players tp to spawn on join
