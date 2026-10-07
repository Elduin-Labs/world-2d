# First time a player joins: step onto the line. The chunk there may not be
# loaded yet, so tick.mcfunction puts them on top of the ground a moment later.
tag @s add w2d_fresh
scoreboard players set @s w2d_age 0
tp @s ~ ~ 0.5
