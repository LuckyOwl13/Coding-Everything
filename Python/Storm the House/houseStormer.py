#Some code copied from this Code Bullet's video "BREAKING Storm The House with an AUTO CLICKER"
#Link: https://www.youtube.com/watch?v=fURH8z3hb6Y
#Otherwise 100% based on the video

import numpy as np
from PIL import ImageGrab
import cv2
from pynput.mouse import Button, Controller as mouseController
from pynput.keyboard import Key, Controller as keyController
import time
import threading

gameCoords = [379,575,850,700]
mouse = mouseController()
keyboard = keyController()


lastShot = [-9999,-9999]
bubbleRadius = 10
shotCounter = 0

def shootSomeFuckers(screen):
	global gameCoords, lastShot, bubbleRadius, shotCounter
	
	for y in range(len(screen)):
		for x in range(len(screen[y])):
			if screen[y][x]<5 \
			  and abs(x - lastShot[0]) > bubbleRadius \
			  and abs(y - lastShot[1]) > bubbleRadius:
				shotCounter += 2
				mouse.position = (x + gameCoords[0] + 5, y + gameCoords[1])
				mouse.click(Button.left,1)
				lastShot = [x,y]
				print("Last shot  @ " + str(lastShot))
				mouse.click(Button.left,1)
				if shotCounter >= 22:
					shotCounter = 0		
					keyboard.press(Key.space)
					keyboard.release(Key.space)					
					keyboard.press(Key.space)
					keyboard.release(Key.space)				
					keyboard.press(Key.space)
					print("Shots low, reloading")
					keyboard.release(Key.space)


print("Waiting to start ...")
#only start program when mouse is in right bottom corner
flag = False

while True:
	while not flag:
		if mouse.position[0] > 1100:
			flag = True


	levelTime = time.time()
	pos = mouse.position
	while flag:
		startTime = time.time()
		screen = np.array(ImageGrab.grab(bbox = gameCoords))
		screen = cv2.cvtColor(screen,cv2.COLOR_BGR2GRAY)
		shootSomeFuckers(screen)
		print("Frame took {} seconds".format(time.time() - startTime))
		reloadDayEnd = np.array(ImageGrab.grab(bbox = [400,300,401,315]))
		reloadDayEnd = cv2.cvtColor(reloadDayEnd,cv2.COLOR_BGR2GRAY)
		print(reloadDayEnd[14][0])
		if reloadDayEnd[0][0] > 250:
			flag = False
			print("~~~~~~~~~~~~ Round end")
		elif reloadDayEnd[14][0] > 175:
			keyboard.press(Key.space)
			print("Shots low, reloading")
			keyboard.release(Key.space)
			shotCounter = 0	































