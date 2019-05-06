	.section .text
	.global main
	.type main%function
	.syntax unified
	/*This program is made by 吳信翰 403530026*/
main:
	mov r0, #12
	mov r1, #20
	b .L1
.L1:
	/*While*/
	cmp r0, r1 @Compare r0 and r1
	bne .L2 @if equal then jump t0 l2
	beq .L4 @if not equal jump to l4

.L2:
	cmp r1, r0 @compare r0 and r1 which is larger
	blt .L3 @if r0 is larger go to l3
	sub r1, r1, r0 @r1 is larger so let r1 minus r0
	b .L1 @back to while loop

.L3:
	sub r0, r0, r1 @r0 is larger so let ro minus r1
	b .L1 @back to while loop

.L4:
	.end @l4 is a place for the program to end
