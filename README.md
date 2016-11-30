# CalHub
Super simple Minecraft server network hub plugin for Bukkit/Spigot/Paper

###Currently does the following:
+ Provides custom join, leave, and death messages
+ Configurable MOTD on join
+ Option to clear chat on join
+ Spawn management (/setspawn, /spawn)
+ Teleport to spawn after falling into the void
+ Option to have players teleport to spawn on join
+ Prevents build/destroy with bypass permissions
+ Prevents dropping/picking up items with bypass permissions
+ Disables weather changes (can be disabled in the config)
+ Options to prevent other world changes
+ Group/Permissions based chat formatting (New!)

###Commands:
+ `/spawn` - Teleports the user to the world spawn
+ `/setspawn` - Sets the world spawn point the user's current location
+ `/motd` - Displays the configured Message Of The Day

###Permission nodes:
Unless otherwise stated, defaults to "op".
+ `calhub.canplace`
+ `calhub.canbreak`
+ `calhub.canbucket`
+ `calhub.candrop`
+ `calhub.canpickup`
+ `calhub.spawn` ("true" by default)
+ `calhub.setspawn`
+ `calhub.motd` ("true" by default)

Chat formatting requires the permission `group.[groupname]`.
Most permissions systems will add this by default for each group,
but you should still consult the manual just in case.

###ToDo/Requested:
+ Option to disable growth and trampling
