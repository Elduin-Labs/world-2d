# First time a player joins: step onto the line. The chunk there may not be
# loaded yet, so tick.mcfunction puts them on top of the ground a moment later.
tag @s add w2d_fresh
scoreboard players set @s w2d_age 0
tp @s ~ ~ 0.5 180 0

# Third-person camera sits 8 blocks behind you, so you can see yourself.
attribute @s minecraft:camera_distance base set 8
tellraw @s {text:"2D World: press F5 until you can see yourself. Walk with A and D.",color:"gold"}
